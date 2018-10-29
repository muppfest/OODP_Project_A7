package view;

public interface IShowPanel<T> {	
	public void edit();
	public void save();
	public void enableFields();
	public void disableFields();
	public void cancel();
	public void refresh();
}