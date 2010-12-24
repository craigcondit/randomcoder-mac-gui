package com.randomcoder.apple.eawt.peer;

import java.util.*;

import com.apple.eawt.Application;
import com.randomcoder.apple.eawt.ApplicationListener;

/**
 * Peer interface for <code>Application</code>.
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
public class ApplicationPeerImpl implements ApplicationPeer
{
	private static final ApplicationPeerImpl INSTANCE
		= new ApplicationPeerImpl(Application.getApplication());

	private final Map<ApplicationListener, com.apple.eawt.ApplicationListener> listeners
		= new HashMap<ApplicationListener, com.apple.eawt.ApplicationListener>();

	private final Application peer;

	public ApplicationPeerImpl()
	{
		peer = new Application();
	}

	private ApplicationPeerImpl(Application peer)
	{
		this.peer = peer;
	}

	public static ApplicationPeer getApplication()
	{
		return INSTANCE;
	}

	public void addAboutMenuItem()
	{
		peer.addAboutMenuItem();
	}

	public synchronized void addApplicationListener(ApplicationListener listener)
	{
		com.apple.eawt.ApplicationListener wrapper = listeners.get(listener);
		if (wrapper == null)
		{
			wrapper = new ApplicationListenerWrapper(listener);
			listeners.put(listener, wrapper);
		}
		peer.addApplicationListener(wrapper);
	}

	public synchronized void removeApplicationListener(ApplicationListener listener)
	{
		com.apple.eawt.ApplicationListener wrapper = listeners.remove(listener);
		if (wrapper == null)
			return;
		
		peer.removeApplicationListener(wrapper);
	}
	
	public void addPreferencesMenuItem()
	{
		peer.addPreferencesMenuItem();
	}

	public boolean getEnabledAboutMenu()
	{
		return peer.getEnabledAboutMenu();
	}

	public boolean getEnabledPreferencesMenu()
	{
		return peer.getEnabledPreferencesMenu();
	}

	public boolean isAboutMenuItemPresent()
	{
		return peer.isAboutMenuItemPresent();
	}

	public boolean isPreferencesMenuItemPresent()
	{
		return peer.isPreferencesMenuItemPresent();
	}

	public void removeAboutMenuItem()
	{
		peer.removeAboutMenuItem();
	}

	public void removePreferencesMenuItem()
	{
		peer.removePreferencesMenuItem();
	}

	public void setEnabledAboutMenu(boolean enable)
	{
		peer.setEnabledAboutMenu(enable);
	}

	public void setEnabledPreferencesMenu(boolean enable)
	{
		peer.setEnabledPreferencesMenu(enable);
	}
}