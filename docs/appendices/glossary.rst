.. _appendix-glossary:

========
Glossary
========

This glossary defines key terms used in the CrateDB reference manual.

.. rubric:: Table of contents

.. contents::
   :local:


.. _glossary-a:


.. _glossary-b:


.. _glossary-c:


.. _glossary-d:


.. _glossary-e:


.. _glossary-f:


.. _glossary-g:


.. _glossary-h:


.. _glossary-i:


.. _glossary-j:


.. _glossary-k:


.. _glossary-l:


.. _glossary-m:

M
=

.. _glossary-metadata-gateway:

**Metadata gateway**
    Persists cluster meta data on disk every time the meta data changes. This
    data is stored persistently across full cluster restarts and recovered
    after nodes are started again.

    .. SEEALSO::

         :ref:`Cluster configuration: Metadata gateway <metadata_gateway>`


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

.. _glossary-routing-column:

**Routing column**
    Values in this column are used to compute a hash which is then used to
    route the corresponding row to a specific shard.

    .. NOTE::

        The routing of rows to a specific shard is not the same as the routing
        of shards to a specific node (also known as :ref:`shard allocation
        <glossary-shard-allocation>`).

    .. SEEALSO::

        :ref:`Storage and consistency: Addressing documents <concepts_addressing_documents>`

        :ref:`Sharding: Routing <routing>`

        :ref:`CREATE TABLE: CLUSTERED clause <ref_clustered_clause>`

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

    .. NOTE::

        Shard allocation is also known as *shard routing*, which is not to be
        confused with :ref:`row routing <glossary-routing-column>`.

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
