import os
import shutil
from os import path
from pydub import AudioSegment

folder_path = 'C:\\Users\\julia\\OneDrive\\Desktop\\Coding_Projects\\CS240\\L3\\Playlist\\src\\MP3'


for filename in os.listdir(folder_path):
    file = os.path.join(folder_path, filename)
    if os.path.isfile(file):
        sound = AudioSegment.from_mp3(file)
        dst = file + ".wav"
        sound.export(dst, format="wav")
        song_folder = "C:\\Users\\julia\\OneDrive\\Desktop\\Coding_Projects\\CS240\\L3\\Playlist\\src\\Songs"
        shutil.move(os.path.abspath(dst), song_folder)
        os.remove(file)

print("Converted any MP3 files to WAV")