package org.randomcoder.apple.eawt;

import java.util.EventListener;

/**
 * Companion interface to Apple's <code>ApplicationListener</code> interface.
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
public interface ApplicationListener extends EventListener
{
	/**
	 * Called when the user selects the About item in the application menu. If
	 * event is not handled, by setting <code>isHandled(true)</code>, a default
	 * About window consisting of the application's name and icon is displayed. To
	 * display a custom About window, designate the event as being handled and
	 * display the appropriate About window.
	 * 
	 * @param event
	 *          an ApplicationEvent initiated by the user choosing About in the
	 *          application menu
	 */
	public void handleAbout(ApplicationEvent event);

	/**
	 * Called when the application receives an Open Application event from the
	 * Finder or another application. Usually this will come from the Finder when
	 * a user double-clicks your application icon. If there is any special code
	 * that you want to run when you user launches your application from the
	 * Finder or by sending an Open Application event from another application,
	 * include that code as part of this handler. The Open Application event is
	 * sent after AWT has been loaded.
	 * 
	 * @param event
	 *          the Open Application event
	 */
	public void handleOpenApplication(ApplicationEvent event);

	/**
	 * Called when the application receives an Open Document event from the Finder
	 * or another application. This event is generated when a user double-clicks a
	 * document in the Finder. If the document is registered as belonging to your
	 * application, this event is sent to your application. Documents are bound to
	 * a particular application based primarily on their suffix. In the Finder, a
	 * user selects a document and then from the File Menu chooses Get Info. The
	 * Info window allows users to bind a document to a particular application.
	 * These events are sent only if the bound application has file types listed
	 * in the Info.plist entries Document Types or CFBundleDocumentTypes. The
	 * ApplicationEvent sent to this handler holds a reference to the file being
	 * opened.
	 * 
	 * @param event
	 *          an Open Document event with reference to the file to be opened
	 */
	public void handleOpenFile(ApplicationEvent event);

	/**
	 * Called when the Preference item in the application menu is selected. Native
	 * Mac OS X applications make their Preferences window available through the
	 * application menu. Java applications are automatically given an application
	 * menu in Mac OS X. By default, the Preferences item is disabled in that
	 * menu. If you are deploying an application on Mac OS X, you should enable
	 * the preferences item with <code>setEnabledPreferencesMenu(true)</code> in
	 * the Application object and then display your Preferences window in this
	 * handler.
	 * 
	 * @param event
	 *          triggered when the user selects Preferences from the application
	 *          menu
	 */
	public void handlePreferences(ApplicationEvent event);

	/**
	 * Called when the application is sent a request to print a particular file or
	 * files. You can allow other applications to print files with your
	 * application by implementing this handler. If another application sends a
	 * Print Event along with the name of a file that your application knows how
	 * to process, you can use this handler to determine what to do with that
	 * request. You might open your entire application, or just invoke your
	 * printing classes. These events are sent only if the bound application has
	 * file types listed in the Info.plist entries Document Types or
	 * CFBundleDocumentTypes. The ApplicationEvent sent to this handler holds a
	 * reference to the file being opened.
	 * 
	 * 
	 * @param event
	 *          a Print Document event with a reference to the file(s) to be
	 *          printed
	 */
	public void handlePrintFile(ApplicationEvent event);

	/**
	 * Called when the application is sent the Quit event. This event is generated
	 * when the user selects Quit from the application menu, when the user types
	 * Command-Q, or when the user control clicks on your application icon in the
	 * Dock and chooses Quit. You can either accept or reject the request to quit.
	 * You might want to reject the request to quit if the user has unsaved work.
	 * Reject the request, move into your code to save changes, then quit your
	 * application. To accept the request to quit, and terminate the application,
	 * set <code>isHandled(true)</code> for the event. To reject the quit, set
	 * <code>isHandled(false)</code>.
	 * 
	 * @param event
	 *          a Quit Application event
	 */
	public void handleQuit(ApplicationEvent event);

	/**
	 * Called when the application receives a Reopen Application event from the
	 * Finder or another application. Usually this will come when a user clicks on
	 * your application icon in the Dock. If there is any special code that needs
	 * to run when your user clicks on your application icon in the Dock or when a
	 * Reopen Application event is sent from another application, include that
	 * code as part of this handler.
	 * 
	 * @param event
	 *          the Reopen Application event
	 */
	public void handleReOpenApplication(ApplicationEvent event);
}
