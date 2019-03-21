/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.cla.egit.github.core.event;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.event.IssueCommentPayload;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Mark Paluch
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class RepositoryIssueCommentPayload extends IssueCommentPayload implements RepositoryAware, SenderAware {

	Repository repository;
	User sender;
}
