/*
 * Copyright (C) 2008-2010 Martin Riesz <riesz.martin at gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pneditor.editor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import org.pneditor.editor.actions.RecordMacroAction;
import org.pneditor.editor.actions.PlayMacroAction;
import org.pneditor.editor.actions.FastPlayMacroAction;
import org.pneditor.util.Command;
import org.pneditor.editor.UndoManager;

/**
 * MacroManager manages macro, and rely on UndoManager
 *
 * @author Martin Riesz <riesz.martin at gmail.com>
 */
public class MacroManager {

    private List<Command> recordedCommands = new ArrayList<Command>();
    private List<Command> buffer = new ArrayList<Command>();
    private int currentCommandIndex = -1;
    private Root root;
    private RecordMacroAction recordMacroAction;
    private PlayMacroAction playMacroAction;
    private FastPlayMacroAction fastPlayMacroAction;
    private boolean recording;
    private boolean playing;

    /**
     * Constructs a new MacroManager
     *
     * @param root Root object
     * @param undoAction action for undo button
     * @param redoAction action for redo button
     */
    public MacroManager(Root root, RecordMacroAction recordMacroAction, PlayMacroAction playMacroAction, FastPlayMacroAction fastPlayMacroAction) {
        this.root = root;
        this.recordMacroAction = recordMacroAction;
        this.playMacroAction = playMacroAction;
        this.fastPlayMacroAction = fastPlayMacroAction;
        this.recording = false;
        this.playing = false;
    }

    public int getRecordedCommandsNumber() {
    	return recordedCommands.size();
    }
    
    public boolean getRecording() {
    	return recording;
    }
    
    public boolean getPlaying() {
    	return playing;
    }
    
    public void setPlaying(boolean set) {
    	playing = set;
    }
    
    public void setRecording(boolean set) {
    	recording  = set;
    }

}
