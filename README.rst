Username Authenticator Plugin
=============================

.. image:: https://curity.io/assets/images/badges/anonymous-authenticator-quality.svg
       :target: https://curity.io/resources/code-examples/status/
       
.. image:: https://curity.io/assets/images/badges/anonymous-authenticator-availability.svg
       :target: https://curity.io/resources/code-examples/status/

A Kotlin-based anonymous username authenticator plugin for the Curity Identity Server.

Building the Plugin
~~~~~~~~~~~~~~~~~~~

You can build the plugin by issue the command ``./gradlew dist``. This will produce a folder in the ``build`` directory with the plugin JAR file and all the dependencies needed called ``authenticators.anonymous``, which can be installed.

Installing the Plugin
~~~~~~~~~~~~~~~~~~~~~

To install the plugin, copy the contents of the ``authenticators.anonymous`` folder into ``${IDSVR_HOME}/usr/share/plugins`` on each node, including the admin node. For more information about installing plugins, refer to the `curity.io/plugins`_.

More Information
~~~~~~~~~~~~~~~~

Please visit `curity.io`_ for more information about the Curity Identity Server.

.. _curity.io/plugins: https://support.curity.io/docs/latest/developer-guide/plugins/index.html#plugin-installation
.. _curity.io: https://curity.io/
