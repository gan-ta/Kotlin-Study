package com.example.activity

import io.realm.RealmObject

open class Person() : RealmObject(){
    var name : String? = null
    var number : String? = null
}

class PersonForList(val name : String?, val number : String?){

}