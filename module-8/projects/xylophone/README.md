# xylophone

- Create a new project named xylophone
- Create a folder named assets and copy .wav files into it
- Goto Flutter packages (https://pub.dev/flutter/packages) and find for a audioplayer package
- Add https://pub.dev/packages/audioplayers do pubspect.yaml (bellow cupertino_icons) and click on Pub get
- Add assets folder into pubspec.yaml
- Create XylophoneApp (stateless) and return a MaterialApp with home Scaffold. Scaffold with body SafeArea
- import audioplayers (import 'package:audioplayers/audioplayers.dart';)
- Add 7 Container with InkWell, each one with different color, and playing a different wav file ontap
    - Tip: Expanded(Container(InkWell...))
