package edu.examples.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.dao.impl.FileNoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.NoteBookLogic;

public class NotebookLogicImpl implements NoteBookLogic {
	
	private final DaoProvider provider = DaoProvider.getInstance();
	private final NoteBookDao dao = provider.getNoteBookDao();
	
	public void add(Note n) throws LogicException {
		
		try {
			dao.save(n);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	public void add(String title, String content) throws LogicException {

		Note n = new Note(title, content);
		try {
			dao.save(n);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
	
	public List<Note> find(String text) throws LogicException{
		List<Note> result = new ArrayList<Note>();
		
		//NoteBookDao dao = new NoteBookDao();
		List<Note> myNotes = null;
		try {
			myNotes = dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
		for(Note n : myNotes) {
			if(isTextInNote(n, text)) {
				result.add(n);
			}
		}
		
		return result;

	}
	
	private boolean isTextInNote(Note n, String text) {
		return n.getTitle().contains(text) || n.getContent().contains(text);
	}
	
	
	public List<Note> find(Date date) throws LogicException{
		List<Note> result = new ArrayList<Note>();
		
		//NoteBookDao dao = new NoteBookDao();
		try {
			List<Note> myNotes = dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
		// ...d1.equals(d2);
		
		return result;
		
	}
	

	public List<Note> allNotes() throws LogicException{
		try {
			return dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

}
