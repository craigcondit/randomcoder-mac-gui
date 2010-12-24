package com.randomcoder.apple.eawt.peer;

import com.apple.eawt.*;

/**
 * Wrapper around <code>ApplicationListener</code>.
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
public class ApplicationListenerWrapper implements ApplicationListener
{
	private final com.randomcoder.apple.eawt.ApplicationListener listener;
	
	public ApplicationListenerWrapper(com.randomcoder.apple.eawt.ApplicationListener listener)
	{
		this.listener = listener;
	}
	
	public com.randomcoder.apple.eawt.ApplicationListener getWrappedListener()
	{
		return listener;
	}

	public void handleAbout(ApplicationEvent event)
	{
		listener.handleAbout(new ApplicationEventWrapper(event));
	}

	public void handleOpenApplication(ApplicationEvent event)
	{
		listener.handleOpenApplication(new ApplicationEventWrapper(event));
	}

	public void handleOpenFile(ApplicationEvent event)
	{
		listener.handleOpenFile(new ApplicationEventWrapper(event));
	}

	public void handlePreferences(ApplicationEvent event)
	{
		listener.handlePreferences(new ApplicationEventWrapper(event));
	}

	public void handlePrintFile(ApplicationEvent event)
	{
		listener.handlePrintFile(new ApplicationEventWrapper(event));
	}

	public void handleQuit(ApplicationEvent event)
	{
		listener.handleQuit(new ApplicationEventWrapper(event));
	}

	public void handleReOpenApplication(ApplicationEvent event)
	{
		listener.handleReOpenApplication(new ApplicationEventWrapper(event));
	}	
}