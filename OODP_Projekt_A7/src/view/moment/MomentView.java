package view.moment;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.MomentController;
import model.Moment;
import view.IView;
import view.View;

public class MomentView extends JPanel implements IView<Moment>{
	private View frame;
	private MomentController controller;
	
	private ListMoments listMomentsPanel;
	// private ShowMoment showMomentPanel;
	// private CreateMoment createMomentPanel;
	
	public MomentView(View frame) {
		this.frame = frame;
		controller = new MomentController();
		list();
	}

	@Override 
	public void list() {

	}
	
	@Override
	public void create() {
				
	}

	@Override
	public void show(int id) {
		Moment moment = controller.showMoment(id);
	}

	@Override
	public void insert(Moment moment) {
		if(controller.insertMoment(moment)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursmomentet lades till.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}

	@Override
	public void update(Moment moment) {
		if(controller.updateMoment(moment)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursmomentet uppdaterades.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}

	@Override
	public void delete(int id) {
		if(controller.deleteMoment(id)) {
			JOptionPane.showMessageDialog(frame,
				    "Kursmomentet togs bort.");
			list();
		} else {
			JOptionPane.showMessageDialog(frame,
				    "Något gick fel.");
		}		
	}
}
