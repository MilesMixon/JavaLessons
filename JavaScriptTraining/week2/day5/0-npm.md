# What is NPM?

NPM stands for Node Package Manager
Allows us to share, publish, and utilize code from/with other developers
NPM comes preinstalled with Nodejs

## NPM Commands

# npm -v
Displays the current version of npm

# npm init
Is a CLI helper for creating a package.json and initializing your Nodejs project
# npm init -y
Same as npm init, but uses all of the defaults

# npm install <package-name>
# npm i <package-name>
Install the specified package to my project

# npm install
# npm i
Installs all the dependencies listed in package.json into my project

# npm uninstall <package-name>
Uninstalls the specified package

# npm update <package-name>
Updates the specified package to the highest version allowed

^ - Updates to the highest available minor version
~ - Updates to the highest availabel patch version

## NPM flags

# -g
Installs a package globally

# -D
# --save-dev
Installs the package as a dev dependency

# --production
Ignore all devDependencies

## Release Candidates
X.Y.Z

X - Major release version
Y - Minor release version
Z - Patch release version

1.1.0



## package.json

## package-lock.json