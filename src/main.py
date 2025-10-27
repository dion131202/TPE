from pathlib import Path
import pandas as pd
import numpy as np

def load_and_aggregate_one_file(
    csv_path: str | Path,
):
    """
    1) Load 1 Excel file
    2) Choose relevant columns
    3) Put all columns to numeric 
    4) Compute sum per column, for some columns we will compute averages

    Parametres
    ----------
    csv_path : file path .csv

    Return
    --------
    df_clean : Dataframe 
    """
    csv_path = Path(csv_path)
    df = pd.read_csv(csv_path)

    # Choose columns to use
    columns_to_use = [["Shot attempts from danger zone",
                                "Shots with rebound",			
                                "Shot attempts",	
                                "Shots on goal from danger zone",		
                                "Scoring chances",	
                                "Scoring chances / shots",	
                                "Goals from danger zone",
                                "Goals",	
                                "One timer goals",
                                "Goals after rebounds"],

                                ["Shots missed net",
                                "Shots blocked"],


                                ["Successful passes  OZ",
                                "Passing accuracy OZ  %",
                                "Time per possession  OZ",
                                "Number of possessions  OZ",
                                "Possession time  OZ"],

                                ["Unsuccessful passes  OZ",
                                "Giveaways  OZ",
                                "Giveaways OZ  %",
                                "Dispossessed  OZ"],

                                ["Puck recoveries  OZ",
                                "Rebound recoveries  OZ",
                                "Interceptions  OZ"],

                                ["Blocked shots",
                                "Puck recoveries  DZ",
                                "Rebound recoveries  DZ",
                                "Interceptions  DZ"],

                                ["Successful passes  DZ",	
                                "Passing accuracy DZ  %", 
                                "Successful controlled exits",	
                                "Successful uncontrolled exits",		
                                "Carry out exits",	
                                "Dump out exits",	
                                "Pass out exits",	 
                                "Controlled exits  %",	
                                "Time per possession  DZ", 
                                "Number of possessions  DZ", 
                                "Possession time  DZ"],	

                                ["Failed uncontrolled exits",	
                                "Failed controlled exits", 
                                "Unsuccessful passes  DZ",
                                "Giveaways  DZ",
                                "Giveaways DZ  %",
                                "Dispossessed  DZ"],

                                ["Passing accuracy NZ  %",		
                                "Successful passes  NZ",
                                "Time per possession  NZ",
                                "Number of possessions  NZ",	
                                "Possession time  NZ"],

                                ["Unsuccessful passes  NZ",
                                "Giveaways NZ  %",	
                                "Giveaways  NZ",
                                "Dispossessed  NZ"],

                                ["Interceptions  NZ",
                                "Puck recoveries  NZ",
                                "Rebound recoveries  NZ"],

                                ["Successful controlled entries",		
                                "Pass in entries",	
                                "Carry in entries",	
                                "Controlled entries  %"],

                                ["Successful uncontrolled entries",	
                                "Dump in entries"],	

                                ["Failed uncontrolled entries",	
                                "Failed controlled entries"],

                                ["Avg. shift length",
                                "Avg. rest time",
                                "Hit taken"],

                                ["Body checks  OZ",
                                "Stick checks  OZ"],

                                ["Body checks  DZ",
                                "Stick checks  DZ"],

                                ["Stick & body checks",	
                                "Body checks",			
                                "Body checks  NZ",	
                                "Stick checks",			
                                "Stick checks  NZ",	 
                                "Hit delivered"],	

                                ["Successful passes",	
                                "Unsuccessful passes",				
                                "Key passes",	
                                "xA",	
                                "xA secondary",	
                                "Passing accuracy  %",	
                                "Passes"],	

                                ["Puck recoveries",			
                                "Rebound recoveries",	
                                "Rebound recoveries  %"],			

                                ["Interceptions"],			


                                ["Giveaways",		
                                "Giveaways  %"],		


                                ["Time per possession",	
                                "Number of possessions",			
                                "Possession time",			
                                "Dispossessed"],				


                                ["Faceoffs won  %"],	

                                ["xG %",	
                                "xG",	
                                "xG per 20",	
                                "xG from danger zone",	
                                "xG behind the net against",	
                                "xG CL against"]
                                ]
    
    # Choose the right columns
    cols = [c for group in columns_to_use for c in group]
   
    df_good_columns = df.loc[:, cols].copy()

    # transform time columns from hh:mm:ss to seconds
    df_good_columns["Possession time  OZ"] = pd.to_timedelta(df_good_columns["Possession time  OZ"], errors="coerce").dt.total_seconds()
    df_good_columns["Possession time  DZ"] = pd.to_timedelta(df_good_columns["Possession time  DZ"], errors="coerce").dt.total_seconds()
    df_good_columns["Possession time  NZ"] = pd.to_timedelta(df_good_columns["Possession time  NZ"], errors="coerce").dt.total_seconds()
    df_good_columns["Possession time"] = pd.to_timedelta(df_good_columns["Possession time"], errors="coerce").dt.total_seconds()
    df_good_columns["Avg. shift length"] = pd.to_timedelta(df_good_columns["Avg. shift length"], errors="coerce").dt.total_seconds()
    df_good_columns["Avg. rest time"] = pd.to_timedelta(df_good_columns["Avg. rest time"], errors="coerce").dt.total_seconds()

    # Choose columns that we will compute average instead of sum
    columns_to_compute_average = {"Scoring chances / shots", 
                                    "Passing accuracy OZ  %",
                                    "Time per possession  OZ",
                                    "Giveaways OZ  %",	
                                    "Passing accuracy DZ  %", 
                                    "Controlled exits  %",	
                                    "Time per possession  DZ", 
                                    "Giveaways DZ  %",
                                    "Passing accuracy NZ  %",		
                                    "Time per possession  NZ",
                                    "Giveaways NZ  %",	
                                    "Controlled entries  %",
                                    "Avg. shift length",
                                    "Avg. rest time",	
                                    "xA",	
                                    "xA secondary",	
                                    "Passing accuracy  %",	
                                    "Rebound recoveries  %",				
                                    "Giveaways  %",		
                                    "Time per possession",				
                                	"Faceoffs won  %",	
                                    "xG %",	
                                    "xG",	
                                    "xG per 20",	
                                    "xG from danger zone",	
                                    "xG behind the net against",	
                                    "xG CL against"}
                               

    # Convert columns to numeric
    for c in df_good_columns.columns:
        df_good_columns[c] = pd.to_numeric(df_good_columns[c], errors="coerce")

    # Sum or average per column
    df_clean = pd.DataFrame()
    for c in df_good_columns:
        if c in columns_to_compute_average:
            m = df_good_columns[c].replace(0, np.nan).mean()
            df_clean.loc[0, c] = m
        else:
            s = df_good_columns[c].sum(min_count=1)  # NaN if all values are NaN
            df_clean.loc[0, c] = s

    return df_clean

df = load_and_aggregate_one_file(
    r"C:/Users/dion1/P2-TPE/ÉTS/ETS-VS-Concordia-25-10-25.csv",
    )
print(df)
