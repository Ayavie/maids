# Device Price Range Prediction

## Overview

This project aims to predict the price range of mobile phone devices based on their features. It includes a Jupyter notebook (`maid.ipynb`) for exploratory data analysis (EDA), data preprocessing, feature engineering, and building a machine learning model using Decision Trees. Additionally, a RESTful API (`api.py`) has been developed to make predictions, and a request script (`req.py`) to interact with the API. A Spring Boot project has also been implemented to provide endpoints for various functionalities using MySQL database.

## Project Structure

- **maid.ipynb**: Jupyter notebook containing the EDA, data preprocessing, feature engineering, and model building.
- **api.py**: Python script implementing the RESTful API for making predictions.
- **req.py**: Python script for making requests to the API.
- **springboot_project**: Directory containing the Spring Boot project with endpoints for interacting with the database and making predictions.

## How to Use

1. **Exploratory Data Analysis**: Open and run the `maid.ipynb` notebook to explore the dataset, preprocess the data, engineer features, and train the machine learning model.

2. **RESTful API**:
   - Run `api.py` to start the API server.
   - Use `req.py` to make requests to the API for predictions.

3. **Spring Boot Project**:
   - Set up the Spring Boot project and configure it to connect to your MySQL database.
   - Run the Spring Boot application to access the following endpoints: 
     - `/predict`: Make predictions from test data on the MySQL database.
     - `/Devices`: List all devices in the test data.
     - `/Devices/{id}`: Get features of a device by its ID.
     - `/saveDevice`: Save a new device features
     - `/Devices/{id}`: Delete a device from the test dataset by its ID.

## Database Schema

The MySQL database contains a table named `testdata` with columns representing features of the devices and a column `price_range` representing the predicted price range.


## Requirements

- Python 3.x
- Jupyter Notebook
- Libraries: pandas, scikit-learn, flask
- Spring Boot
- MySQL database



