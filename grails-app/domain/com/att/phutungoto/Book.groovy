package com.att.phutungoto
class Book {
	String code
	String name

	    static constraints = {
	        code(blank: false)
	        name(blank: true,nullable:true)
	    }
}
