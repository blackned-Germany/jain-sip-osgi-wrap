* Wraps jain sip api and reference implementation to OSGi bundles usable for the MUP
* Cloned from: https://github.com/RestComm/jain-sip
* Removed every log4j thingy (and the deprecated methods), which prevented a good OSGi integretion because of stupid imports of internal packages.
* Also fixed the MultiMap "extension" to remove the remove method to be Java 8 compatible.
* Add option to pass class loader to SipFactory, otherwise there would be class loader problems with OSGi. (Class.forName is used for stack initializiation)
