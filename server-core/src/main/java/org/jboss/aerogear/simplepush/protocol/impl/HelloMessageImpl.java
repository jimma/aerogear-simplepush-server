/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.aerogear.simplepush.protocol.impl;

import static org.jboss.aerogear.simplepush.util.UUIDUtil.newUAID;
import static org.jboss.aerogear.simplepush.util.UUIDUtil.nullOrEmpty;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import org.jboss.aerogear.simplepush.protocol.HelloMessage;

public class HelloMessageImpl implements HelloMessage {

    private final String uaid;
    private final Set<String> channelIds;

    public HelloMessageImpl() {
        this("");
    }

    public HelloMessageImpl(final String uaid) {
        this(uaid, Collections.<String> emptySet());
    }

    public HelloMessageImpl(final String uaid, final Set<String> channelIds) {
        if (nullOrEmpty(uaid)) {
            this.uaid = newUAID();
            this.channelIds = Collections.emptySet();
        } else {
            this.uaid = UUID.fromString(uaid).toString();
            this.channelIds = channelIds;
        }
    }

    @Override
    public String getUAID() {
        return uaid;
    }

    @Override
    public Set<String> getChannelIds() {
        return Collections.unmodifiableSet(channelIds);
    }

    @Override
    public Type getMessageType() {
        return Type.HELLO;
    }

    @Override
    public String toString() {
        return "HandshakeImpl[messageType=" + getMessageType() + ", uaid=" + uaid + ", channelIds=" + channelIds + "]";
    }

}
