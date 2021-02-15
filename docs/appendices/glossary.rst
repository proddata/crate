.. _appendix-glossary:

========
Glossary
========

This glossary defines key terms used in the CrateDB reference manual.

.. rubric:: Table of contents

.. contents::
   :local:


.. _glossary-a:

A
=

.. _glossary-analyzing phase:

**Analyzing phase**
    PLACEHOLDER TEXT


.. _glossary-b:


.. _glossary-c:

C
=

.. _glossary-clustered-by:

**Clustered by**
    PLACEHOLDER TEXT


.. _glossary-d:


.. _glossary-e:


.. _glossary-f:


.. _glossary-g:


.. _glossary-h:


.. _glossary-i:


.. _glossary-j:


.. _glossary-k:


.. _glossary-l:

L
=

.. _glossary-local-gateway:

**Local gateway**
    PLACEHOLDER TEXT


.. _glossary-m:


.. _glossary-n:

N
=

.. _glossary-node:

**Node**
    PLACEHOLDER TEXT

.. _glossary-node-types:

**Node types**
    PLACEHOLDER TEXT


.. _glossary-o:

O
=

.. _glossary-operator:

**Operator**
    PLACEHOLDER TEXT


.. _glossary-p:

P
=

.. _glossary-primary-shard:

**Primary shard**
    PLACEHOLDER TEXT


.. _glossary-q:


.. _glossary-r:

R
=

.. _glossary-rebalancing:

**Rebalancing**
    PLACEHOLDER TEXT

.. _glossary-replica-shard:

**Replica shard**
    PLACEHOLDER TEXT


.. _glossary-s:

S
=

.. _glossary-shard:

**Shard**
    PLACEHOLDER TEXT

.. _glossary-shard-allocation:

**Shard allocation**
    The process by which CrateDB allocates :ref:`shards <glossary-shard>` to a
    specific :ref:`nodes <glossary-node>`.

    .. SEEALSO::

        :ref:`ddl_shard_allocation`

        :ref:`Cluster configuration: Routing allocation <conf_routing>`

        :ref:`Sharding: Number of shards <number-of-shards>`

        :ref:`Altering tables: Changing the number of shards
        <alter-shard-number>`

        :ref:`Altering tables: Reroute shards <ddl_reroute_shards>`

.. _glossary-shard-recovery:

**Shard recovery**
    The process by which CrateDB synchronizes a :ref:`replica shard
    <glossary-replica-shard>` from a :ref:`primary shard
    <glossary-primary-shard>`.

    Shard recovery can happen during :ref:`node <glossary-node>` startup, after
    node failure, when :ref:`replicating <replication>` a primary shard, when
    moving a shard to another node (i.e., when :ref:`rebalancing
    <glossary-rebalancing>` the cluster), or during :ref:`snapshot restoration
    <snapshot-restore>`.

    A shard that is being recovered cannot be queried until the recovery
    process is complete.

    .. SEEALSO::

        :ref:`Cluster settings: Recovery <indices.recovery>`

        :ref:`System information: Checked node settings
        <sys-node-checks-settings>`


.. _glossary-t:


.. _glossary-u:


.. _glossary-v:


.. _glossary-w:

W
=

.. _glossary-warming:

**Warming**
    PLACEHOLDER TEXT


.. _glossary-x:


.. _glossary-y:


.. _glossary-z:
