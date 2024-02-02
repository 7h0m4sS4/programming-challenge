import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

'''
Learnings:
- Seperator in csv file is not always a comma, it can be a semicolon or a tab
- The given dataset is not always clean, it can contain dots, commas, and other characters that need to be removed 
    or else the automatic type conversion will not work removing math capabilities
- No check for empyt values in the dataset, this can lead to errors
'''
# The maximum temperature is the second column MxT, the minimum temperature the third column MnT.
# Read in the data
df_weather = pd.read_csv('weather.csv', sep=',', header=0)
print(df_weather.head())
smallest_temp_spread = df_weather['MxT'].sub(df_weather['MnT']
                                             ).sort_values(ascending=True).head(1)

print(f'Day with smallest temperature spread: {int(
    df_weather.iloc[smallest_temp_spread.index.values[0]]['Day'])} with a temperature spread of {smallest_temp_spread.values}  ')
# Read the file, then print the name of the country with the highest number of people per square kilometre.
# Read in the data
df_countries = pd.read_csv('countries.csv', sep=';', header=0)
# Data cleaning, remove the dot in the population column, remove the ,and following characters (Population does not have any half people) and convert the column to int64 to be able to do math operations
translator = str.maketrans('', '', '.')
df_countries['Population'] = df_countries['Population'].str.translate(
    translator)
df_countries['Population'] = df_countries['Population'].str.split(',').str[0]
df_countries['Population'] = df_countries['Population'].astype('int64')
print(df_countries.head())

highest_num_people = df_countries['Population'].div(
    df_countries['Area (km²)']).sort_values(ascending=False).head(1)

print(f'Country with highest population density: {df_countries.iloc[highest_num_people.index.values[0]]["Name"]} with a density of {np.round(
    highest_num_people.values, 2)}')
