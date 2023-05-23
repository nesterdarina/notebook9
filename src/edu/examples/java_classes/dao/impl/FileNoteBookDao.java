package edu.examples.java_classes.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;

public class FileNoteBookDao implements NoteBookDao{

	private DaoProvider provider = DaoProvider.getInstance();
	
	@Override
	public void save(Note n) throws DaoException{
		FileWriter writer;
		
		try {			
			writer = new FileWriter("filename");
		} catch (IOException e) {
			throw new DaoException("Notepad data not saved.", e);
		}		
	}

	@Override
	public List<Note> allNotes() throws DaoException {
		List<Note> result = new ArrayList<Note>();
		return DaoProvider.allNotes();

	}
}