package com.initgrep.springit.link;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import com.initgrep.springit.comment.Comment;
import com.initgrep.springit.common.Auditable;

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
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
public class Link extends Auditable {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	@NotEmpty(message = "Please enter the title")
	private String title;

	@NonNull
	@NotEmpty(message = "Please enter the URL")
	@URL(message="please enter a valid URL")
	private String url;

	// comments
	@OneToMany(mappedBy = "link", fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();

	public void addComment(Comment comment) {
		this.getComments().add(comment);

	}

	public String getDomainName() throws URISyntaxException {
		URI uri = new URI(this.url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	public String prettyTime() {
		PrettyTime pt = new PrettyTime();
		return pt.format(convertToDateViaInstant(getCreationDate()));
	}

	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
		return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}

}
