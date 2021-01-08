package thriftbox.mobile.domain.auth

import thriftbox.mobile.server_api.service.auth.ILoginRequest

class PojoLoginRequest(
                       override val email: String,
                       override val password: String
) : ILoginRequest
