#!/bin/bash
set -e

# Define Android SDK root in a local, writable directory
ANDROID_SDK_ROOT=/app/.android-sdk
mkdir -p $ANDROID_SDK_ROOT
cd $ANDROID_SDK_ROOT

# Download Android command line tools
wget https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip -O tools.zip
unzip tools.zip -d cmdline-tools && rm tools.zip
mv cmdline-tools/cmdline-tools/* cmdline-tools/
rmdir cmdline-tools/cmdline-tools

# Install essential SDK components
yes | cmdline-tools/bin/sdkmanager --sdk_root=$ANDROID_SDK_ROOT --licenses
yes | cmdline-tools/bin/sdkmanager --sdk_root=$ANDROID_SDK_ROOT \
  "platform-tools" "platforms;android-36" "build-tools;35.0.0"

# Export environment variables for Jules sessions
echo "export ANDROID_HOME=$ANDROID_SDK_ROOT" >> ~/.bashrc
echo "export ANDROID_SDK_ROOT=$ANDROID_SDK_ROOT" >> ~/.bashrc
echo "export PATH=\$ANDROID_SDK_ROOT/platform-tools:\$ANDROID_SDK_ROOT/cmdline-tools/bin:\$PATH" >> ~/.bashrc
