package com.example.activity

import io.realm.RealmObject

open class Person: RealmObject(){
    var name : String? = null
    var number : String? = null
}