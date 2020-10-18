This document will explain the code structure for simple API

@author michael

Endpoints
==========
1. The API will expose an endpoint which accepts the user information (customerID, initialCredit).
2. Another Endpoint will output the user information showing Name, Surname, balance, and transactions of the accounts.

The API implementation (Client side) and exposer (Server side) have been implemented in a simplistic sense

Client Side
===========
Interface IQasarBankApi with 2 endpoints
Configuration file containing API details and auth information
XML entities defined Account, Transaction and UserInfo
AccountOrder concept as the minimum contract for API account creation


Server Side
===========
Exposes account creation (POST) and user information retrieval (GET)
Qasar User Profile must exist before a new account can be created
Qasar Account and Qasar Transactions have been kept separate
Processor concepts for asynchronous queue of orders (account creation) and transactions


Web Admin Front End
===================
A simple gui implemented to visualize the client inputs and views of transactions
Basic HTML and CSS
Simple gui to be hooked to API


Libraries used
==============
Jersey 1.19 for simple API implementation
JUnit 4.8.2 for simple API testing framework






