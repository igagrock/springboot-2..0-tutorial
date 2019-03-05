package com.initgrep.springit.vote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.initgrep.springit.common.Auditable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Getter @Setter
public class Vote  extends Auditable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	private int vote;

}
