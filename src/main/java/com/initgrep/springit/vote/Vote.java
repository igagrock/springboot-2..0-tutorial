package com.initgrep.springit.vote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.initgrep.springit.common.Auditable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity

@EqualsAndHashCode(callSuper=false)
@Getter @Setter
public class Vote  extends Auditable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int vote;

}
