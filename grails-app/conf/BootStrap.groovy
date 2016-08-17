import my.example.Role
import my.example.User
import org.apache.shiro.crypto.hash.Sha512Hash

class BootStrap {

    def init = { servletContext ->

        def adminRole = new Role(name: "Administrator")
        adminRole.addToPermissions("*:*")
        adminRole.save()

        def userRole = new Role(name:"User")
        userRole.addToPermissions("Home:index")
        userRole.save()

        def admin = new User(username: "admin", passwordHash: new Sha512Hash("admin").toHex())
        admin.addToRoles(adminRole)
        admin.save()

        def user = new User(username: "user", passwordHash: new Sha512Hash("user").toHex())
        user.addToRoles(userRole)
        user.save()
    }
    def destroy = {
    }
}
