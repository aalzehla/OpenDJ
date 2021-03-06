/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2006-2008 Sun Microsystems, Inc.
 */
package org.forgerock.opendj.config.server.spi;

import org.forgerock.i18n.LocalizableMessageBuilder;
import org.forgerock.opendj.config.server.ConfigChangeResult;
import org.forgerock.opendj.ldap.Entry;

/**
 * This interface defines the methods that a Directory Server component should
 * implement if it wishes to be able to receive notification of changes to a
 * configuration entry.
 */
public interface ConfigChangeListener {
    /**
     * Indicates whether the configuration entry that will result from a
     * proposed modification is acceptable to this change listener.
     *
     * @param configEntry
     *            The configuration entry that will result from the requested
     *            update.
     * @param unacceptableReason
     *            A buffer to which this method can append a human-readable
     *            message explaining why the proposed change is not acceptable.
     * @return {@code true} if the proposed entry contains an acceptable
     *         configuration, or {@code false} if it does not.
     */
    boolean configChangeIsAcceptable(Entry configEntry, LocalizableMessageBuilder unacceptableReason);

    /**
     * Attempts to apply a new configuration to this Directory Server component
     * based on the provided changed entry.
     *
     * @param configEntry
     *            The configuration entry that containing the updated
     *            configuration for this component.
     * @return Information about the result of processing the configuration
     *         change.
     */
    ConfigChangeResult applyConfigurationChange(Entry configEntry);
}
