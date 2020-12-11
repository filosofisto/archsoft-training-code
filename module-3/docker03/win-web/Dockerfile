FROM mcr.microsoft.com/windows/servercore/iis
# The image is over 5GB in size so will take a long time to download

RUN powershell -NoProfile -Command Remove-Item -Recurse C:\inetpub\wwwroot\*

WORKDIR /inetpub/wwwroot
# set current working directory

COPY index.html .
# Copies the index.html file from the root of the repo to . (WORKDIR)

# No ENTRYPOINT needed as this image config includes ENTRYPOINT
