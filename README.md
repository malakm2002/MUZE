# Client-Side MUZE application:
## The client has a graphical user interface (GUI).
## The user opens the client application and connects to the server application using the server domain name and port number.
## The user is given the option to register or to login.
### If the user is not registered, they can sign up and provide the server with name, email address, username, and password. To complete the registration, the user is expected to upload their first audio file.
### In the case of a registered user, the user logs in with their existing account where the server performs authentication by verifying the username and password.
## When the user is authenticated, they can get a list of all files together with the names of users who provided each file. The list should be displayed in the client GUI.

# Server-Side MUZE application:
### The server takes as a command line argument the port number on which it would be listening.
### The server allows the users to register and login.
### Every time a new user signs up for a new account, the server adds a new user.
### Every time a user logs in, the server authenticates them by verifying their username and password.
### The server application manages a database that stores user accounts and details.
### The server serves multiple clients simultaneously.
