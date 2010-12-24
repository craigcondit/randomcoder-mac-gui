package org.randomcoder.apple.eawt;

import java.util.EventObject;

/**
 * Analog for Apple's <code>ApplicationEvent</code> object.
 * 
 * <pre>
 * Copyright (c) 2007, Craig Condit. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *     
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS &quot;AS IS&quot;
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * </pre>
 */
abstract public class ApplicationEvent extends EventObject
{
	protected ApplicationEvent(Object source)
	{
		super(source);
	}

	/**
	 * Provides the filename associated with a particular AppleEvent. When the
	 * ApplicationEvent corresponds to an Apple Event that needs to act on a
	 * particular file, the ApplicationEvent carries the name of the specific file
	 * with it. For example, the Print and Open events refer to specific files.
	 * For these cases, this returns the appropriate file name.
	 * 
	 * @return the full path to the file associated with the event, if applicable,
	 *         otherwise <code>null</code>
	 */
	abstract public String getFilename();

	/**
	 * Determines whether an ApplicationListener has acted on a particular event.
	 * An event is marked as having been handled with
	 * <code>setHandled(true)</code>.
	 * 
	 * @return <code>true</code> if the event has been handled, otherwise
	 *         <code>false</code>
	 */
	abstract public boolean isHandled();

	/**
	 * Sets the state of the event. After this method handles an ApplicationEvent,
	 * it may be useful to specify that it has been handled. This is usually used
	 * in conjunction with <code>getHandled()</code>. Set to <code>true</code>
	 * to designate that this event has been handled. By default it is
	 * <code>false</code>.
	 * 
	 * @param state
	 *          <code>true</code> if the event has been handled, otherwise
	 *          <code>false</code>.
	 */
	abstract public void setHandled(boolean state);
}
