//primaryStage.setTitle("JavaFX App");
//
//        FileChooser fileChooser = new FileChooser();
//
//        Button button = new Button("Select File");
//        ImageView imageView = new ImageView();
//        button.setOnAction(e -> {
//        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
//        fileChooser.getExtensionFilters().addAll(
//        new FileChooser.ExtensionFilter("All Images", "*.*"),
//        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
//        new FileChooser.ExtensionFilter("PNG", "*.png")
//        );
//
//        File selectedFile = fileChooser.showOpenDialog(primaryStage);
//        if (selectedFile != null) {
//        Image image = new Image(selectedFile.toURI().toString());
//        imageView.setImage(image);
//        }
//
//        });
//        imageView.setFitWidth(100);
//        imageView.setFitHeight(100);
//        VBox vBox = new VBox(button, imageView);
//        Scene scene = new Scene(vBox, 960, 600);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();