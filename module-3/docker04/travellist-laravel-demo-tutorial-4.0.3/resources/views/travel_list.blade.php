@extends('main')

@section('content')

            <div class="map_container clearfix">

                <div class="column x3">

                    <div class="column x5">

                        <ul class="list">
                            <li class="header visited">Visited</li>
                            @foreach ($visited as $place)
                                <li>{{ $place->name }}</li>
                            @endforeach
                        </ul>
                    </div>

                    <div class="column x5">

                        <ul class="list">
                            <li class="header togo">To Go</li>
                            @foreach ($togo as $newplace)
                                <li>{{ $newplace->name }}</li>
                            @endforeach
                        </ul>
                    </div>
                </div>

                <div class="column x7">
                    <div id="map" class="map"></div>
                </div>

                <div class="clearfix"></div>
            </div>

@endsection

@section('footer')
    <div class="footer">
        <p>
            <a href="https://github.com/do-community/travellist-laravel-demo/tree/tutorial-04" target="_blank" title="Source Code on Github">Travellist Laravel Demo</a>
        </p>
    </div>
@endsection

@section('script')
    <script type="text/javascript">
        var map;
        var mapLat = 0;
        var mapLng = 0;
        var mapDefaultZoom = 2;

        map = new ol.Map({
            target: "map",
            layers: [
                new ol.layer.Tile({
                    source: new ol.source.OSM({
                        url: "https://a.tile.openstreetmap.org/{z}/{x}/{y}.png"
                    })
                })
            ],
            view: new ol.View({
                center: ol.proj.fromLonLat([mapLng, mapLat]),
                zoom: mapDefaultZoom
            })
        });


        @foreach ($togo as $place)
          add_map_point({{ $place->lat }}, {{ $place->lng }}, "/img/marker_togo.png");
        @endforeach

        @foreach ($visited as $place)
            add_map_point({{ $place->lat }}, {{ $place->lng }}, "/img/marker_visited.png");
        @endforeach
    </script>


@endsection
