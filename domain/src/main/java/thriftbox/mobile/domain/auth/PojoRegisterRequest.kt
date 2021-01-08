package thriftbox.mobile.domain.auth

import thriftbox.mobile.server_api.service.auth.IRegisterRequest

class PojoRegisterRequest(
    override val email: String,
    override val password: String,
    override val name: String
) : IRegisterRequest
