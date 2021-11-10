package com.infy.UserMS.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class mykey implements Serializable {
	@Id
	Integer buyerid;
	Integer prodid;

}
