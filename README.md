# Apple Social Identity Provider for Keycloak

An extension to [Keycloak](https://www.keycloak.org/) that provides support for [Sign in with Apple](https://developer.apple.com/sign-in-with-apple/).

Sign in with Apple follows the [OIDC](https://openid.net/) standard but uses some unusual parts of the protocol which are not implemented yet in Keycloak. Those specificities are:
* Apple sends the Authentication Response as a POST request if scopes were requested;
* User data (email, first name and last name) is received in the body of the authentication response—there is no Userinfo endpoint;
* User data is provided only the first time the user authorizes the client on his Apple account;
* The Token Request must be authentified by a JWT token signed by a specific private key.

The present extension addresses all these requirements.

## Installation

1. Download the latest release of the provider JAR file [here](https://github.com/BenjaminFavre/keycloak-apple-social-identity-provider/releases).
1. Install the provider JAR file following Keycloak instructions [there](https://www.keycloak.org/docs/latest/server_development/index.html#using-the-keycloak-deployer).

## Configuration

In Keycloak admin console:
1. Add an identity provider and select *Apple*.
1. Fill *Client secret* with the base 64 content of your private key file (trim delimiters and new lines).

   e.g., if your private key is:
   
       -----BEGIN PRIVATE KEY-----
       Rp6vMlHPYTHnyucsPvFk8gTzdYtTueMbmVznAtkUKhD9HPcI3bLKDrr0b2mNJLfS
       tsyvhbpyMUIpaffKQcY7IUuM20ecYBjiyjkLuX5eDQUInWUINfCCyXQnNdSU4K1j
       2z4IJrvacQz1PFrL0Tj4lt72jSxikzMBHWsGdFyT90bx0R26GR4YCudKxltozVrK
       PsUC1cdy
       -----END PRIVATE KEY-----
   
   then you should set *Client secret* with:
   
       Rp6vMlHPYTHnyucsPvFk8gTzdYtTueMbmVznAtkUKhD9HPcI3bLKDrr0b2mNJLfStsyvhbpyMUIpaffKQcY7IUuM20ecYBjiyjkLuX5eDQUInWUINfCCyXQnNdSU4K1j2z4IJrvacQz1PFrL0Tj4lt72jSxikzMBHWsGdFyT90bx0R26GR4YCudKxltozVrKPsUC1cdy

1. Fill *Team ID* and *Key ID* with corresponding values found in Apple Developer console.
1. Set Default Scopes to 'openid%20name%20email' to retrieve email, firstname and lastname from apple.
