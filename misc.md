*python-pip : package mgmt system used to install and manage software packages written in python
*ccm : dev tool for creating local cassandra clusters
*managing interfaces( [http://www.tecmint.com/create-multiple-ip-addresses-to-one-single-network-interface/][multiple-ip]):
**assign multiple ip to same interface: 
***ifconfig lo:0 127.0.0.2 up
***ip addr add 127.0.0.3 dev lo
**delete the virtual interface: ifconfig lo:0 down
