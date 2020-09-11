package com.flawlessconcepts.gadsproject2020.adapters

import androidx.fragment.app.Fragment


class FragmentTag {
    var fragment: Fragment? = null
    var tag: String? = null

    constructor(fragment: Fragment?) {
        this.fragment = fragment
        //this.tag = tag
    }

    constructor() {}

}