package thriftbox.mobile.route

import androidx.navigation.NavController
import thriftbox.mobile.R

class NavigationComponentRouter(
    private val navController: NavController
) : IRouter {

    override fun goToRegisterScreen() {
        navController.navigate(R.id.registerFragment)
    }

    override fun goToLoginScreen() {
        navController.navigate(R.id.loginFragment)
    }

    override fun resetToHomeScreen() {
        //todo
    }
}