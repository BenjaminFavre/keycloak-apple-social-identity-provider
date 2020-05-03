# Apple Social Identity Provider for Keycloak

An extension to [Keycloak](https://www.keycloak.org/) that provides support for [Sign in with Apple](https://developer.apple.com/sign-in-with-apple/).

Sign in with Apple follows the [OIDC](https://openid.net/) standard but uses some unusual parts of the protocol which are not implemented yet in Keycloak. Those specificities are:
* Apple sends the Authentication Response as a POST request if scopes were requested;
* User data (email, first name and last name) is received in the body of the authentication response—there is no Userinfo endpoint;
* User data is provided only the first time the user authorizes the client on his Apple account;
* The Token Request must be authentified by a JWT token signed by a specific private key.

The present extension addresses all these requirements.

## Installation

[Follow Keycloak instructions](https://www.keycloak.org/docs/latest/server_development/index.html#using-the-keycloak-deployer)

## Configuration

* When adding an identity provider, select *Apple*.
* Fill *Client secret* with the base 64 content of your private key file (trim delimiters and new lines).
* Fill *Team ID* and *Key ID* with corresponding values found in Apple Developper console.
