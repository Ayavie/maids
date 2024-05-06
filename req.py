import requests
import pandas as pd 
# URL of Flask API endpoint
url = 'http://localhost:5000/predict'  

# Read test dataset
test_df = pd.read_csv('test.csv')

# Device specifications for prediction
device_specs = test_df.iloc[0,].to_dict(orient='records')

# Send POST request to the Flask API endpoint
response = requests.post(url, json=device_specs)

# Check if request was successful (status code 200)
if response.status_code == 200:
    # Extract predicted price from response
    predicted_price = response.json()['predicted_price']
    print(f'Predicted Price: {predicted_price}')
else:
    print(f'Error: {response.text}')
