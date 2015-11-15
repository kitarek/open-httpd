/*
 * Copyright 2015 Arek Kita
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.kitarek.elasthttpd.plugins.consumers.file.consumer;

import io.github.kitarek.elasthttpd.commons.MimeTypeDetector;
import io.github.kitarek.elasthttpd.commons.TemplatedHttpResponder;
import io.github.kitarek.elasthttpd.plugins.consumers.file.producer.HttpFileProducer;

public class HttpFileRequestConsumerFactory {

	private TemplatedHttpResponder templatedHttpResponder;

	public HttpFileRequestConsumerFactory() {
		templatedHttpResponder = new TemplatedHttpResponder();
	}

	public HttpFileRequestConsumer createConsumerForReadOperation() {
		MimeTypeDetector mimeTypeDetector = new MimeTypeDetector();
		HttpFileProducer httpFileProducer = new HttpFileProducer(mimeTypeDetector, templatedHttpResponder);
		return new HttpFileReadRequestConsumer(httpFileProducer, templatedHttpResponder);
	}

	public HttpFileRequestConsumer createConsumerForWriteOperation() {
		return new HttpFileWriteRequestConsumer(templatedHttpResponder);
	}

	public HttpFileRequestConsumer createConsumerForDeleteOperation() {
		return new HttpFileDeleteRequestConsumer(templatedHttpResponder);
	}
}
