Username Authenticator Plugin
=============================

A Kotlin-based anonymous username authenticator plugin for the Curity Identity Server.

Building the Plugin
~~~~~~~~~~~~~~~~~~~

You can build the plugin by issue the command ``gradle dist``. This will produce a folder in the ``build`` directory with the plugin JAR file and all the dependencies needed called ``authenticators.anonymous``, which can be installed.

Installing the Plugin
~~~~~~~~~~~~~~~~~~~~~

To install the plugin, copy the full directory into ``${IDSVR_HOME}/usr/share/plugins`` on each node, including the admin node. For more information about installing plugins, refer to the `curity.io/plugins`_.

Required Dependencies
"""""""""""""""""""""

For a list of the dependencies and their versions, run ``gradle dependencies``. Ensure that all of these are installed in the plugin group; otherwise, they will not be accessible to this plug-in and run-time errors will result.

More Information
~~~~~~~~~~~~~~~~

Please visit `curity.io`_ for more information about the Curity Identity Server.

.. _curity.io/plugins: https://support.curity.io/docs/latest/developer-guide/plugins/index.html#plugin-installation
.. _curity.io: https://curity.io/
