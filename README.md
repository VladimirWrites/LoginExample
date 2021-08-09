# LoginExample

## How to run the app?

#### Option 1:

1) Use `debug.keystore` certificate provided in the repo to build the project
2) Use the following credentials to do login:
    - Email: `test@email.com`
    - Password: `test123`

#### Option 2:

1) Replace `google-services.json` in the app module with your own
2) Add user to your authenticated user list and use it's credentials to login

## What the app does?

It uses Firebase Auth to authenticate a user using email and password.\
After the user is authenticated the biometric prompt will be shown.\
If the user uses biometric to authenticate, UID received from Firebase will be encrypted and stored.\
When the app is opened the next time, the biometric prompt is shown immediately.\
If the user decides to use it, email and password input will be skipped, and the user will be redirected to the Home screen.

## License

     Copyright 2021 Vladimir Jovanović

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.