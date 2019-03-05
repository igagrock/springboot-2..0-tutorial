package com.initgrep.springit.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.initgrep.springit.common.Auditable;
import com.initgrep.springit.link.Link;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Getter @Setter
@ToString
public class Comment extends Auditable {
	
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String body;
	
	//link
	@ManyToOne
	@NonNull
	private Link link;

	
}
