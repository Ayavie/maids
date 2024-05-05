from flask import Flask, request, jsonify
import pandas as  pd
from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import StandardScaler, FunctionTransformer
from sklearn.tree import DecisionTreeClassifier
import pickle

def feature_engineering(df):  
    
    #Convert dict df to dataframe 
    df = pd.DataFrame.from_dict(df,orient='index').T
    # Keep only important features 
    df = df.loc[:,['battery_power', 'px_height', 'px_width', 'ram']]
    
    #Combine two features
    df['px_dims'] = df['px_height'] * df['px_width']
    
    # Drop original features  
    df.drop(['px_width', 'px_height'], axis=1, inplace=True)
    
    return df

app = Flask(__name__)

# Load the trained model
with open('trained_model.pkl', "rb") as f:
    model = pickle.load(f)


@app.route('/predict', methods=['POST'])
def predict_price():
    # Get device specs from the request
    specs = request.json

    
    # Validate input
    required_fields = ['battery_power', 'blue', 'clock_speed', 'dual_sim', 'fc', 'four_g',
                       'int_memory', 'm_dep', 'mobile_wt', 'n_cores', 'pc', 'px_height',
                       'px_width', 'ram', 'sc_h', 'sc_w', 'talk_time', 'three_g',
                       'touch_screen', 'wifi']
    for field in required_fields:
        if field not in specs:
            return jsonify({'error': f'Missing field: {field}'}), 400
    
    # Convert specs to array for model prediction
      # Convert specs to dictionary for model prediction
    input_data = {field:specs[field] for field in required_fields}
    
    # Make prediction
    predicted_price = model.predict(input_data)[0]

    return jsonify({'predicted_price': predicted_price.item()})





if __name__ == '__main__':
    app.run(debug=True)
