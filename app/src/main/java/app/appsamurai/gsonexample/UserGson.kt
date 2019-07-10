package app.appsamurai.gsonexample

import java.io.Serializable

/**
 * Created by Ukyo on 2019-07-10.
 *
 */
class UserGson : Serializable {

    var id: Int? = null
    var name: String? = null
    var username: String? = null
    var email: String? = null
    var address: Address? = null
    var phone: String? = null
    var website: String? = null
    var company: Company? = null

    inner class Address {
        var street: String? = null
        var suite: String? = null
        var city: String? = null
        var zipcode: String? = null
        var geo: Geo? = null
    }

    inner class Geo {
        var lat: String? = null
        var lng: String? = null
    }

    inner class Company {
        var name: String? = null
        var catchPhrase: String? = null
        var bs: String? = null
    }

}