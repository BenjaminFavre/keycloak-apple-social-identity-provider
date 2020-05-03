package fr.benjaminfavre.provider;

import org.keycloak.broker.oidc.OIDCIdentityProviderConfig;
import org.keycloak.models.IdentityProviderModel;

class AppleIdentityProviderConfig extends OIDCIdentityProviderConfig {
    AppleIdentityProviderConfig() {}

    AppleIdentityProviderConfig(IdentityProviderModel identityProviderModel) {
        super(identityProviderModel);
    }

    public String getKeyId() {
        return getConfig().get("keyId");
    }

    public String getTeamId() {
        return getConfig().get("teamId");
    }
}
