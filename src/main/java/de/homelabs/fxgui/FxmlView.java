package de.homelabs.fxgui;

public enum FxmlView {
	HOME {

		@Override
		public String getFxmlPath() {
			return "/fxml/mainview.fxml";
		}
	},
	FORMVIEW {

		@Override
		public String getFxmlPath() {
			return "/fxml/formview.fxml";
		}
	};

	public abstract String getFxmlPath();
}
