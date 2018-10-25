package view;

import model.Observable;

public interface Observer {
		public void notify (Observable observable);
}
