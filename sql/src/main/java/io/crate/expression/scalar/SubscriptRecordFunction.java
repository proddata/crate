/*
 * Licensed to CRATE Technology GmbH ("Crate") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  Crate licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial agreement.
 */

package io.crate.expression.scalar;

import io.crate.data.Input;
import io.crate.data.Row;
import io.crate.metadata.FunctionIdent;
import io.crate.metadata.FunctionInfo;
import io.crate.metadata.Scalar;
import io.crate.metadata.TransactionContext;
import io.crate.metadata.functions.Signature;
import io.crate.types.DataTypes;
import io.crate.types.RowType;

import javax.annotation.Nullable;
import java.util.List;

public final class SubscriptRecordFunction extends Scalar<Object, Object> {

    public static final String NAME = "_subscript_record";
    public static final Signature SIGNATURE = Signature.scalar(
        NAME,
        RowType.EMPTY.getTypeSignature(),
        DataTypes.STRING.getTypeSignature(),
        DataTypes.UNDEFINED.getTypeSignature());

    public static void register(ScalarFunctionModule module) {
        module.register(
            SIGNATURE,
            (signature, dataTypes) ->
                new SubscriptRecordFunction(
                    signature,
                    (RowType) dataTypes.get(0))
        );
    }

    private final Signature signature;
    private final RowType rowType;
    private final FunctionInfo info;

    public SubscriptRecordFunction(Signature signature, RowType rowType) {
        this.signature = signature;
        this.rowType = rowType;
        this.info = new FunctionInfo(
            new FunctionIdent(NAME, List.of(rowType, DataTypes.STRING)),
            DataTypes.UNDEFINED
        );
    }

    @Override
    public FunctionInfo info() {
        return info;
    }

    @Nullable
    @Override
    public Signature signature() {
        return signature;
    }

    @Override
    @SafeVarargs
    public final Object evaluate(TransactionContext txnCtx, Input<Object>... args) {
        Row record = (Row) args[0].value();
        if (record == null) {
            return null;
        }
        String fieldName = (String) args[1].value();
        int idx = rowType.fieldNames().indexOf(fieldName);
        if (idx < 0) {
            // The ExpressionAnalyzer should prevent this case
            throw new IllegalStateException(
                "Couldn't find fieldname `" + fieldName + "` within RowType `" + rowType + "`");
        }
        return record.get(idx);
    }
}
